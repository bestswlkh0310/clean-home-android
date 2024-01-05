package com.bestswlkh0310.clean_home.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.clean_home.model.ItemModel
import com.bestswlkh0310.clean_home.ui.theme.Body
import com.bestswlkh0310.clean_home.ui.theme.shadow1

@Composable
fun ItemCeil(
    modifier: Modifier = Modifier,
    item: ItemModel,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .clip(RoundedCornerShape(8.dp))
            .shadow1(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Body(
            modifier = Modifier
                .padding(start = 8.dp),
            text = item.itemName
        )

        Button(
            onClick = {

            }
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 8.dp),
                text = "완료"
            )
        }
    }
}